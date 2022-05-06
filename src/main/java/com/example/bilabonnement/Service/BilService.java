package com.example.bilabonnement.Service;


import com.example.bilabonnement.Repository.BilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilService {

    @Autowired
    BilRepo bilRepo;
}
