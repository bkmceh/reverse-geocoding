package inforest.reversegeocoding.repository;

import inforest.reversegeocoding.model.entity.AddressMapperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeocodingRepository extends JpaRepository<AddressMapperEntity, Long> {
}
