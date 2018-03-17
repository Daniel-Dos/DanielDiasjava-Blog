package br.com.danieldias.persistencia;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoCursorNotFoundException;
import com.mongodb.MongoException;
import com.mongodb.MongoQueryException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import br.com.danieldias.commons.Constantes;
import br.com.danieldias.model.Pessoa;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class PessoaDao implements MongoDAO<Pessoa> {

	MongoClient conexao;
	MongoCollection<Document> collectionPessoas;

	public PessoaDao() {
		conexao = MongoDBFactory.createConnection();
		collectionPessoas = 
				conexao.getDatabase(Constantes.BANCO_NOME)
				.getCollection(Constantes.COLLECTION_NOME);
	}

	@Override
	public void inserir(Pessoa entidade) throws MongoException {

		List<Document> jugs = new ArrayList<>();
		jugs.add(new Document(Constantes.NOME,entidade.getJugs())
				.append(Constantes.DESCRICAO, entidade.getDescricao()));
		
		collectionPessoas.insertOne(new Document(Constantes.NOME,entidade.getNome())
				 .append(Constantes.ENDERECO, 
							new Document(Constantes.ESTADO,entidade.getEndereco().getEstado())
							)
				 .append(Constantes.IDADE,entidade.getIdade())
				 .append(Constantes.JUGS, jugs)
				 );
	}

	@Override
	public void alterar(Pessoa entidade) throws MongoException {
		 
		collectionPessoas.updateOne(porId(entidade.get_id()),
				new Document("$set",
						new Document(Constantes.IDADE,entidade.getIdade())
						.append(Constantes.NOME, entidade.getNome())
						.append(Constantes.ENDERECO, 
								new Document(Constantes.ESTADO,entidade.getEndereco().getEstado()))
						)
				);
	}

	@Override
	public void deletar(ObjectId _id) throws MongoQueryException {
		collectionPessoas.findOneAndDelete(porId(_id));
	}

	@Override
	public MongoCursor<Document> listarTodos() throws MongoCursorNotFoundException, MongoQueryException {
		return collectionPessoas.find().iterator();
	}

	@Override
	public Document porId(ObjectId _id) throws MongoQueryException {
		return collectionPessoas.find(eq(Constantes.ID,_id)).first();
	}
}