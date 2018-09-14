package sbi.oneshot.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sbi.oneshot.entities.Go;

import java.util.List;

@RepositoryRestResource
public interface GoRepository extends PagingAndSortingRepository<Go, String> {


    @Query("SELECT go FROM Go go WHERE go.codeSite like %:codeSite% " +
            "AND go.region like %:region% " +
            "AND go.typologie like %:typologie%" )
    Page<Go> rechercher(@Param("codeSite") String codeSite,
            @Param("typologie") String typologie,
            @Param("region") String region, Pageable pageable);

    @Query("SELECT go.codeSite from Go go where go.codeSite like %:codeSite% " +
            "and go.region like %:region% " +
            "and go.typologie like %:typologie%")
    String[] rechercherGo(@Param("codeSite") String codeSite,
                          @Param("region") String region,
                          @Param("typologie") String typologie)
                         ;
}
