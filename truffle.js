require('babel-register');
require('babel-polyfill');

module.exports = {
    networks: {
        development: {
            host: "localhost",
            port: 8545,
            network_id: "*" // Match any network id
        },

        rinkeby: {  // testnet
            // from: "0x370b102d85c1336d988ecf7b499bd76cdc4d603f",
            // gas: 30000,
            // gasPrice: 10 * 1e9,
            host: "localhost",
            port: 8547,
            network_id: 4
        },

        mainnet: {
            host: "localhost",
            port: 8549,
            network_id: 1,
            gasPrice: 10 * 1e9
        }
    },

    solc: {
        optimizer: {
            enabled: true,
            runs: 200
        }
    }
};