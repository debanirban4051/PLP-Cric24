package com.cg.cric24.dao;

import java.util.List;

import com.cg.cric24.entity.StadiumBean;
import com.cg.cric24.exception.StadiumNotFoundException;

public interface IStadiumDao {

	StadiumBean create (StadiumBean stadium);
	
	StadiumBean retrieveById(int stadiumId) throws StadiumNotFoundException;
	
	List<StadiumBean> retrieveByName(String stadiumName) throws StadiumNotFoundException;
	
	List<StadiumBean> retrieveAll() throws StadiumNotFoundException;
	
	StadiumBean update(StadiumBean stadium);
	
	Boolean delete(int id) throws StadiumNotFoundException;
}
