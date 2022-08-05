package service;

import repository.ApartmentRepositoryImpl;

public class ApartmentServiceImpl extends ApartmentRepositoryImpl {

    private static ApartmentRepositoryImpl apartmentRepository;

    public ApartmentServiceImpl(ApartmentRepositoryImpl apartmentRepository) {
        ApartmentServiceImpl.apartmentRepository = apartmentRepository;
    }
}
