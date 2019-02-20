package com.epam.engx.cleancode.errorhandling.task1.persistence;

import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Address;
import com.epam.engx.cleancode.errorhandling.task1.AddressDao;
import com.epam.engx.cleancode.errorhandling.task1.persistence.thirdpartyjar.SqlService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlAddressDao implements AddressDao {

    SqlService sqlService;

    public Address getHomeAddress(String userId) throws DAOException {
        Address address;
        try {
            address = (Address) sqlService.queryUserHomeAddress(userId);
        } catch (SQLException e) {
            throw new DAOException("Get home address SQLException", e);
        }
        return address;
    }

    public List<Address> getDeliveryAddresses(String userId) throws DAOException {
        List<Address> addresses = new ArrayList<Address>();
        try {
            for (Map addressData : sqlService.queryUserDeliveryAddress(userId))
                addresses.add(new Address(addressData));
        } catch (SQLException e) {
            throw new DAOException("Get delivery addresses SQLException", e);
        }
        return addresses;
    }
}
