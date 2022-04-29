package org.diginamic.fr.jdbc.dao;

import java.util.List;

/**
 * Idao est une interface générique pour toutes les futures classes de type Idao
 * @author AP
 *
 * @param <T>
 */
public interface IDao<T> {
	List<T> extraire();
	void insert(T data);
	int update(T ancienData , T nouveauData);
	boolean delete(T data);
}
