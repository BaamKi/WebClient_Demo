package com.openapi.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReadyRequestDto {


    private Payment payment;
    private Merchant merchant;
    private Url url;
    private Buyer buyer;
    private String tax;
    private OtherParam otherParam;
    private List<Product> product;
    private String surcharge;
    private String shipTo;
    private String billTo;
    private String dutyFreeShop;
    private String airline;
    private Settings settings;



    @Builder
    public ReadyRequestDto(Payment payment, Merchant merchant, Url url, Buyer buyer, String tax,
                           OtherParam otherParam, List<Product> product, String surcharge, String shipTo,
                           String billTo, String dutyFreeShop, String airline, Settings settings) {
        this.payment = payment;
        this.merchant = merchant;
        this.url = url;
        this.buyer = buyer;
        this.tax = tax;
        this.otherParam = otherParam;
        this.product = product;
        this.surcharge = surcharge;
        this.shipTo = shipTo;
        this.billTo = billTo;
        this.dutyFreeShop = dutyFreeShop;
        this.airline = airline;
        this.settings = settings;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Payment {
        private String lang;
        @JsonProperty("transaction_type")
        private String transactionType;
        @JsonProperty("order_id")
        private String orderId;
        private String currency;
        private String amount;
        private String paymentMethod;
        private String multiPaymentMethod;

        @Builder
        public Payment(String lang, String transactionType, String orderId, String currency, String amount,
                       String paymentMethod, String multiPaymentMethod) {
            this.lang = lang;
            this.transactionType = transactionType;
            this.orderId = orderId;
            this.currency = currency;
            this.amount = amount;
            this.paymentMethod = paymentMethod;
            this.multiPaymentMethod = multiPaymentMethod;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Merchant {
        private String mid;
        private String shop;
        private String partnerCode;

        @Builder
        public Merchant(String mid, String shop, String partnerCode) {
            this.mid = mid;
            this.shop = shop;
            this.partnerCode = partnerCode;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Url {
        @JsonProperty("return_url")
        private String returnUrl;
        @JsonProperty("status_url")
        private String statusUrl;

        @Builder
        public Url(String returnUrl, String statusUrl) {
            this.returnUrl = returnUrl;
            this.statusUrl = statusUrl;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Buyer {
        private String email;
        private String name;
        private String phoneNumber;

        @Builder
        public Buyer(String email, String name, String phoneNumber) {
            this.email = email;
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class OtherParam {
        private String param1;
        private String param2;
        private String param3;

        @Builder
        public OtherParam(String param1, String param2, String param3) {
            this.param1 = param1;
            this.param2 = param2;
            this.param3 = param3;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Product {
        private String name;
        private String quantity;
        private String unitPrice;
        private String link;

        @Builder
        public Product(String name, String quantity, String unitPrice, String link) {
            this.name = name;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.link = link;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Settings {
        private String autoclose;
        private String ostype;
        private String displayType;
        private String siteForeignCurrency;
        private String callFromApp;
        private String callFromScheme;
        private String issuerCountry;

        @Builder
        public Settings(String autoclose, String ostype, String displayType, String siteForeignCurrency,
                        String callFromApp, String callFromScheme, String issuerCountry) {
            this.autoclose = autoclose;
            this.ostype = ostype;
            this.displayType = displayType;
            this.siteForeignCurrency = siteForeignCurrency;
            this.callFromApp = callFromApp;
            this.callFromScheme = callFromScheme;
            this.issuerCountry = issuerCountry;
        }
    }
}
