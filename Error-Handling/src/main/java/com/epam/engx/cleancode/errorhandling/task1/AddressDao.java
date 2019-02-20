package com.epam.engx.cleancode.errorhandling.task1;

import com.epam.engx.cleancode.errorhandling.task1.persistence.DAOException;
import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Address;

import java.util.List;

public interface AddressDao {

    Address getHomeAddress(String userId) throws DAOException;

    List<Address> getDeliveryAddresses(String userId) throws DAOException;

}
