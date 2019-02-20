package com.epam.engx.cleancode.errorhandling.task1;

import com.epam.engx.cleancode.errorhandling.task1.persistence.DAOException;
import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Address;

import java.util.List;

public class AddressAction {

    private AddressDao addressDao;
    private OrderDao orderDao;
    private String userId;
    private Address defaultAddress;

    public Address getPreferredAddress() throws ActionException {
        try {
            List<Address> deliveryAddresses = addressDao.getDeliveryAddresses(userId);
            List<Address> orderAddresses = orderDao.getOrderAddresses(userId);
            if (!deliveryAddresses.isEmpty())
                return deliveryAddresses.get(0);
            else if (!orderAddresses.isEmpty())
                return orderAddresses.get(orderAddresses.size() - 1);
            else if (addressDao.getHomeAddress(userId) != null)
                return addressDao.getHomeAddress(userId);
            else return defaultAddress;
        } catch (DAOException e) {
            throw new ActionException("DAOException in get preferred address", e);
        }
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDefaultAddress(Address defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
}
