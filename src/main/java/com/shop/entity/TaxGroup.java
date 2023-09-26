package com.shop.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Represents a tax group with rates and category.
 */
@Entity
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaxGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the tax group.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The tax rate associated with the tax group.
     */
    @OneToOne
    private TaxRate taxRate;

    /**
     * The tax category of the tax group.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaxCategory taxCategory;

    /**
     * An additional tax rate associated with the tax group (optional).
     */
    @OneToOne
    private TaxRate additionalTax;
}
