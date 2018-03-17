package br.com.danieldias.persistencia;

import org.bson.Document;

import com.mongodb.client.MongoCursor;

import br.com.danieldias.model.Pessoa;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public interface MongoDAO {

	void inserir(Pessoa pessoa);
	void atualizar(Pessoa pessoa);
	void excluir(Object _id);
	Document porId(Object _id);
	MongoCursor<Document>mostraTodos();
}