package app.dao;

import java.util.List;

public interface IDataAccess<K, V>  {
	public V add(K key, V value);
	public V update(K key, V value);
	public V get(K key);
	public V delete(K key);
	public List<V> getAll();
}
