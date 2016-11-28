/*
 * Copyright 2014 Mopote.com
 *
 * The Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package mpt.market.example;

import java.util.Date;

import mpt.market.sdk.recharge.RechargeOrder;
import mpt.market.sdk.recharge.RechargeOrderResponse;
import mpt.market.sdk.request.Order;
import mpt.market.sdk.utils.DateUtils;
import mpt.market.sdk.utils.HttpClientUtils;

import com.google.gson.Gson;

/**
 * 
 * @since 1.0
 * @author Allen
 */
public class RechargeExample {

    public static void main(String[] args) {
        try {
            String cpId = "200266";
            String apiKey = "AYiZxwvT6IDeSffqWRaCyre9FDGQy5IT";
            String secretKey = "aspRKtT074Bipl8E";
            String url = "http://122.224.212.160:8980/recharge/order";

            Order order = new Order();
            order.setId(String.valueOf(System.currentTimeMillis()));
            order.setDescription("");
            order.setType(Order.TYPE_TRAFFIC);
            order.setAmount(10240);
            order.setUseRange(Order.RANGE_COUNTRY);
            order.setPhoneNumber("18676130271");
            order.setCallbackUrl("http://mailiuliang.com.cn/recharge/callback.action");
            order.setTime(DateUtils.format(new Date(), "yyyyMMddHHmmss"));
            System.out.println(new Gson().toJson(order));
            RechargeOrder rechargeOrder = new RechargeOrder();
            RechargeOrderResponse recharge = rechargeOrder.recharge(order, cpId, apiKey, secretKey, url);
            System.out.println(new Gson().toJson(recharge));
            
            HttpClientUtils.post("http://115.238.91.240:10362/fm-market/recharge/order?d=14f134c4c320b46bbf58a2f1bfbcd19d&t=1425711399450&s=ac2c2d23dc2cebf0337494e1f44838b3b1e9efa1&a=200266", null, null, null, null);
//            http://122.224.212.160:8980/token/get
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
