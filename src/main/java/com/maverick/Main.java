package com.maverick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.LinkedList;

@SpringBootApplication @RestController @RequestMapping("/load")
public class Main{
	private final LoadRepository repo;
	private static final record newLoad(String loadingPoint,  String unloadingPoint, String productType,
		String truckType, String sid, String date,
		String comment, int noOfTrucks, int weight,
		int id){}

	public Main(LoadRepository Repo){
		repo = Repo;
	}

	public static void main(String args[]){
		SpringApplication.run(Main.class, args);
	}

	@GetMapping("{Id}")
	public Load getLoad(@PathVariable("Id") int id){
		return repo.findById(id).get();
	}

	@PostMapping
	public void addLoad(@RequestBody newLoad req){
		Load load = new Load();
		load.setId(req.id());
	    load.setLoadingPoint(req.loadingPoint());
	    load.setUnloadingPoint(req.unloadingPoint());
	    load.setProductType(req.productType());
	    load.setTruckType(req.truckType());
	    load.setComment(req.comment());
	    load.setDate(req.date());
	    load.setSid(req.sid());
	    load.setNoOfTrucks(req.noOfTrucks());
	    load.setWeight(req.weight());
	    repo.save(load);
    }

	@DeleteMapping("{Id}")
	public void deleteLoad(@PathVariable("Id") int id){
		repo.deleteById(id);
	}

	@PutMapping("{Id}")
	public void updateLoad(@RequestBody newLoad req, @PathVariable("Id") int id){
		Load load = repo.findById(id).get();
		load.setId(req.id());
	    load.setLoadingPoint(req.loadingPoint());
	    load.setUnloadingPoint(req.unloadingPoint());
	    load.setProductType(req.productType());
	    load.setTruckType(req.truckType());
	    load.setComment(req.comment());
	    load.setDate(req.date());
	    load.setSid(req.sid());
	    load.setNoOfTrucks(req.noOfTrucks());
	    load.setWeight(req.weight());
		repo.save(load);
	}

	@GetMapping("shipper/{Sid}")
	public LinkedList<Load> getLoadsOfShipper(@PathVariable("Sid") String sid){
		return new LinkedList<>();
	}
}