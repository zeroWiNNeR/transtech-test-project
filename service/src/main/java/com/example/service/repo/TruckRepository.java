package com.example.service.repo;

import com.example.service.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Created by Aleksei Vekovshinin on 10.12.2020
 */
@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {

}
