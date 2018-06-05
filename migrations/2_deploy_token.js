'use strict';

const EventTradeTokenSample = artifacts.require('EventTradeTokenSample.sol');


module.exports = function(deployer, network) {
    deployer.deploy(EventTradeTokenSample);
};
