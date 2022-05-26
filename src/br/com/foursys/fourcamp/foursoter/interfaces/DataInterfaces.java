package br.com.foursys.fourcamp.foursoter.interfaces;

import java.util.List;

public interface DataInterfaces <T> {

	public void save(T objetc);
	
	public List<T> listAll();
	
	public void update(T objetc);
	
	public void delete(T objetc);

}