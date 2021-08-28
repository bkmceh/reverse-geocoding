package inforest.reversegeocoding.server.repository;

import inforest.reversegeocoding.server.model.entity.AddressMapperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeocodingRepository extends JpaRepository<AddressMapperEntity, Long> {
}
