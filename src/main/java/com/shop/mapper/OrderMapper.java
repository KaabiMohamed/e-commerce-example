package com.shop.mapper;

import com.shop.dto.CartDto;
import com.shop.dto.OrderDto;
import com.shop.entity.Cart;
import com.shop.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * This interface defines mapping between Order and OrderDto objects in a shopping application.
 */
@Mapper
public interface OrderMapper {

    /**
     * Instance of the OrderMapper generated by MapStruct.
     */
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    /**
     * Maps an Order entity to an OrderDto.
     *
     * @param entity The Order entity to map.
     * @return The mapped OrderDto.
     */
    OrderDto mapToDto(Order entity);

    /**
     * Maps a Cart to an Order entity.
     *
     * @param cart The Cart to map.
     * @return The mapped Order entity.
     */
    Order mapFromCart(Cart cart);
}
