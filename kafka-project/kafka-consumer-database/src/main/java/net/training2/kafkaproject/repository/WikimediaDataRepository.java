package net.training2.kafkaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.training2.kafkaproject.entity.Wikimedia;

public interface WikimediaDataRepository extends JpaRepository<Wikimedia, Long> {

}
