package com.example.Marketplace.repository;
import com.example.Marketplace.entity.Listing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Integer>{


    //make an inner join with sellers later to display seller name with listing and also dont include seller id cus that is supposed to be private
    @Query(value = "SELECT * FROM listings WHERE seller_id = :sellerID",
            nativeQuery=true
    )
    public List<Listing> findBySellerID(@Param("sellerID") int sellerID);


}
