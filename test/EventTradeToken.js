'use strict';

import {assertEquals} from './helpers/asserts';

const EventTradeToken = artifacts.require('EventTradeToken.sol');

contract('EventTradeTokenTest', function (accounts) {
    it('test construction', async function () {
        const token = await EventTradeToken.new();
    });

    it('new clients', async function () {
        const token = await EventTradeToken.new();
        await token.newClient('4a756c6961');
        assertEquals(await token.getClientBalance('4a756c6961'), 50);
        assertEquals(await token.getClientBalance('0040001aa1'), 0);
    });

    it('new products', async function () {
        const token = await EventTradeToken.new();
        await token.addProduct(1, '542d5368697274', 20);
        await token.addProduct(2, '4d7567', 10);
        assertEquals(await token.getProductsCount(), 2);

        const product_array = await  token.getProductByIndex(1);
        assertEquals(product_array[0], 2);
        assertEquals(product_array[2], 10);

        token.addProducts([2, 3], ['4d7567', '537765657473'], [10, 10]);
        // assertEquals(await token.getProductsCount(), 2);
    });
});