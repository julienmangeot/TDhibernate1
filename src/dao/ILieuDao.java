package dao;

import java.util.List;

import model.Lieu;

public interface ILieuDao {
	public boolean createLieu(Lieu lieu);
	
	public List<Lieu> showLieu();

}
