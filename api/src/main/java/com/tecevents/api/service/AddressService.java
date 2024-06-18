package com.tecevents.api.service;

import com.tecevents.api.domain.Address.Address;
import com.tecevents.api.domain.event.Event;
import com.tecevents.api.domain.event.EventRequestDTO;
import com.tecevents.api.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public Address createAddress(EventRequestDTO data, Event event) {
        Address newAddress = new Address();
        newAddress.setCity(data.city());
        newAddress.setUf(data.state());
        newAddress.setEvent(event);

        return  addressRepository.save(newAddress);
    }
}
