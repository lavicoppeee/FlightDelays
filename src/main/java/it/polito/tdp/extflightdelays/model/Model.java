package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private SimpleWeightedGraph<Airport,DefaultWeightedEdge> graph;
	private Map<Integer,Airport> idMap;
	private ExtFlightDelaysDAO dao;
	
	public Model() {
		idMap=new HashMap<Integer,Airport>();
		dao=new ExtFlightDelaysDAO();
		this.dao.loadAllAirports(idMap);
		
	}
	
	public void creaGrafo(int x) {
		this.graph=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//aggiungiamo i vertici
		for(Airport a: dao ) {
			if(dao.getAirlinesNumber(a)>x) {
				this.graph.addVertex(a);
			}
		}
	}
}

