package dao;

import java.util.List;
import model.Formation;
import model.Lieu;

public interface IFormationDao {
	
	public boolean createFormation(Formation formation);

	public List<Formation> showFormations();
	
	public List<Formation> getFormations(Lieu lieu);
}
