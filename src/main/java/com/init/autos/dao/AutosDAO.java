package com.init.autos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.autos.entitys.Auto;

public interface AutosDAO extends JpaRepository<Auto, Long>{

}
