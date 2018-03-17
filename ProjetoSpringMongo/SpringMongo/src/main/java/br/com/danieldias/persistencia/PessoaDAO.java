package br.com.danieldias.persistencia;

import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import br.com.danieldias.commons.Constantes;
import br.com.danieldias.model.Pessoa;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
@Repository
public class PessoaDAO implements MongoDAO {

	MongoClient conexao;
	MongoDatabase dataBase;
	MongoCollection<Document> collectionPessoas;

	public PessoaDAO() {
		conexao = new MongoClient();
		dataBase = conexao.getDatabase(Constantes.BANCO_NOME);
		collectionPessoas = dataBase.getCollection(Constantes.COLLECTION_NOME);
	}

	@Override
	public void inserir(Pessoa pessoa) {

		List<Document> jugs = new ArrayList<>();
		jugs.add(new Document(Constantes.NOME,pessoa.getJugs()));

		collectionPessoas.insertOne(
				new Document(Constantes.NOME,pessoa.getNome())
				.append(Constantes.IDADE, pessoa.getIdade())
				.append(Constantes.PROFISSAO, pessoa.getProfissao())
				.append(Constantes.ENDERECO, 
						new Document(Constantes.CIDADE,pessoa.getEndereco().getCidade())
						.append(Constantes.BAIRRO, pessoa.getEndereco().getBairro())
						.append(Constantes.ESTADO, pessoa.getEndereco().getEstado())
						)
				.append(Constantes.NASCIMENTO, pessoa.getDataNascimento().getTime())
				.append(Constantes.JUGS,jugs)
				);
	}

	@Override
	public void atualizar(Pessoa pessoa) {

		collectionPessoas.updateOne(eq(Constantes.NOME,pessoa.getNome()),
				new Document("$set",
						new Document(Constantes.IDADE,pessoa.getIdade())
						.append(Constantes.PROFISSAO, pessoa.getProfissao())
						.append(Constantes.ENDERECO, 
								new Document(Constantes.CIDADE,pessoa.getEndereco().getCidade())
								.append(Constantes.BAIRRO, pessoa.getEndereco().getBairro())
								.append(Constantes.ESTADO, pessoa.getEndereco().getEstado())
								)
						)
				);
	}

	@Override
	public void excluir(Object _id) {

		collectionPessoas.deleteOne(porId(_id));
	}

	@Override
	public Document porId(Object _id) {

		return collectionPessoas.find(eq("_id",_id)).first();
	}

	@Override
	public MongoCursor<Document> mostraTodos() {

		return collectionPessoas.find().iterator();
	}
}