'use strict';

import {assertEquals} from './helpers/asserts';
import {expectThrow} from './helpers/expectThrow';

const EventTradeToken = artifacts.require('EventTradeToken.sol');

contract('EventTradeTokenTest', function (accounts) {
    it('test construction', async function () {
        const token = await EventTradeToken.new();
    });

    it('new clients', async function () {
        const token = await EventTradeToken.new();
        await token.newClient("Julia");
        assertEquals(await token.getClientBalance("Julia"), 50);
        assertEquals(await token.getClientBalance("Empty"), 0);
    });

    it('new products', async function () {
        const token = await EventTradeToken.new();
        await token.addProduct(1, 'T-Shirt', 20, 100);
        await token.addProduct(2, 'Mug', 10, 100);
        assertEquals(await token.getProductsCount(), 2);

        const product_array = await  token.getProductByIndex(1);
        assertEquals(product_array[0], 2);
        assertEquals(product_array[2], 10);

        await token.addProduct(2, 'Mug2', 10, 100);
        await token.addProduct(3, 'Pen', 5, 100);

        assertEquals(await token.getProductsCount(), 3);
    });

    it('buy products', async function () {
        const token = await EventTradeToken.new();
        await token.addProduct(1, 'T-Shirt', 20, 1);
        await token.addProduct(2, 'Mug', 70, 2);

        await token.newClient("Julia");

        // await expectThrow(token.buyProduct("Julia", 2));
        // await token.buyProduct("Julia", 1);
        // await expectThrow(token.buyProduct("Julia", 1));
    });
});