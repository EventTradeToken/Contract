'use strict';

const EventTradeToken = artifacts.require('EventTradeToken.sol');


module.exports = function(deployer, network) {
    deployer.deploy(EventTradeToken);
};
