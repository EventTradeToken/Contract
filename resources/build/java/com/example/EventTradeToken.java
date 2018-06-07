package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class EventTradeToken extends Contract {
    private static final String BINARY = "6080604052600380546032600755600160a860020a031916331790556112cf8061002a6000396000f30060806040526004361061013d5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663014bf9c4811461014257806305d2035b14610165578063095ea7b31461018e57806318160ddd146101b25780631b943d2d146101d957806323b872dd146101f157806340c10f191461021b5780635786fd401461023f5780635fcf8d2c14610254578063661884631461026f57806370a08231146102935780637a27b71f146102b45780637d64bcb4146102cf57806382e02a07146102e45780638da5cb5b14610321578063a9059cbb14610352578063b23471a514610376578063b80872f41461043d578063c3e4bbbd14610494578063d4090427146104b2578063d73dd623146104ca578063dd62ed3e146104ee578063dea41a0f14610515578063f2fde38b14610546575b600080fd5b34801561014e57600080fd5b5061016360ff60043516602435604435610567565b005b34801561017157600080fd5b5061017a610684565b604080519115158252519081900360200190f35b34801561019a57600080fd5b5061017a600160a060020a03600435166024356106a5565b3480156101be57600080fd5b506101c761070b565b60408051918252519081900360200190f35b3480156101e557600080fd5b506101c7600435610711565b3480156101fd57600080fd5b5061017a600160a060020a0360043581169060243516604435610791565b34801561022757600080fd5b5061017a600160a060020a0360043516602435610908565b34801561024b57600080fd5b506101c7610a23565b34801561026057600080fd5b5061017a60ff60043516610a29565b34801561027b57600080fd5b5061017a600160a060020a0360043516602435610a97565b34801561029f57600080fd5b506101c7600160a060020a0360043516610b89565b3480156102c057600080fd5b5061017a600435602435610ba4565b3480156102db57600080fd5b5061017a610bc8565b3480156102f057600080fd5b506102ff60ff60043516610c6e565b6040805160ff9094168452602084019290925282820152519081900360600190f35b34801561032d57600080fd5b50610336610cee565b60408051600160a060020a039092168252519081900360200190f35b34801561035e57600080fd5b5061017a600160a060020a0360043516602435610cfd565b34801561038257600080fd5b506040805160206004803580820135838102808601850190965280855261016395369593946024949385019291829185019084908082843750506040805187358901803560208181028481018201909552818452989b9a998901989297509082019550935083925085019084908082843750506040805187358901803560208181028481018201909552818452989b9a998901989297509082019550935083925085019084908082843750949750610dde9650505050505050565b34801561044957600080fd5b506040805160206004803580820135838102808601850190965280855261017a953695939460249493850192918291850190849080828437509497505093359450610e839350505050565b3480156104a057600080fd5b5061016360043560ff60243516610f00565b3480156104be57600080fd5b50610163600435611005565b3480156104d657600080fd5b5061017a600160a060020a03600435166024356110af565b3480156104fa57600080fd5b506101c7600160a060020a0360043581169060243516611148565b34801561052157600080fd5b5061053060ff60043516611173565b6040805160ff9092168252519081900360200190f35b34801561055257600080fd5b50610163600160a060020a03600435166111e6565b60055460016000808311156105c1575060005b828160ff1610156105c1576005805460ff831690811061059657fe5b600091825260209091206003909102015460ff878116911614156105b957600091505b60010161057a565b811561067c576040805160608101825260ff8881168252602082018881529282018781526005805460018101825560009190915292517f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db06003909402938401805460ff1916919093161790915591517f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db182015590517f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db2909101555b505050505050565b60035474010000000000000000000000000000000000000000900460ff1681565b336000818152600260209081526040808320600160a060020a038716808552908352818420869055815186815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a350600192915050565b60015490565b600061076e600480548060200260200160405190810160405280929190818152602001828054801561076357602002820191906000526020600020905b8154815260019091019060200180831161074e575b505050505083610e83565b15610788575060008181526006602052604090205461078c565b5060005b919050565b6000600160a060020a03831615156107a857600080fd5b600160a060020a0384166000908152602081905260409020548211156107cd57600080fd5b600160a060020a03841660009081526002602090815260408083203384529091529020548211156107fd57600080fd5b600160a060020a038416600090815260208190526040902054610826908363ffffffff61127b16565b600160a060020a03808616600090815260208190526040808220939093559085168152205461085b908363ffffffff61128d16565b600160a060020a0380851660009081526020818152604080832094909455918716815260028252828120338252909152205461089d908363ffffffff61127b16565b600160a060020a03808616600081815260026020908152604080832033845282529182902094909455805186815290519287169391927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929181900390910190a35060019392505050565b600354600090600160a060020a0316331461092257600080fd5b60035474010000000000000000000000000000000000000000900460ff161561094a57600080fd5b60015461095d908363ffffffff61128d16565b600155600160a060020a038316600090815260208190526040902054610989908363ffffffff61128d16565b600160a060020a03841660008181526020818152604091829020939093558051858152905191927f0f6798a560793a54c3bcfe86a93cde1e73087d944c0ea20544137d412139688592918290030190a2604080518381529051600160a060020a038516916000917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9181900360200190a350600192915050565b60055490565b60008060006005805490501115610a8c575060005b60055460ff82161015610a8c578260ff1660058260ff16815481101515610a6157fe5b600091825260209091206003909102015460ff161415610a845760019150610a91565b600101610a3e565b600091505b50919050565b336000908152600260209081526040808320600160a060020a038616845290915281205480831115610aec57336000908152600260209081526040808320600160a060020a0388168452909152812055610b21565b610afc818463ffffffff61127b16565b336000908152600260209081526040808320600160a060020a03891684529091529020555b336000818152600260209081526040808320600160a060020a0389168085529083529281902054815190815290519293927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929181900390910190a3600191505b5092915050565b600160a060020a031660009081526020819052604090205490565b60408051918252805191829003602090810183209383529051918290030190201490565b600354600090600160a060020a03163314610be257600080fd5b60035474010000000000000000000000000000000000000000900460ff1615610c0a57600080fd5b6003805474ff00000000000000000000000000000000000000001916740100000000000000000000000000000000000000001790556040517fae5184fba832cb2b1f702aca6117b8d265eaf03ad33eb133f19dde0f5920fa0890600090a150600190565b600080600060058460ff16815481101515610c8557fe5b60009182526020909120600390910201546005805460ff928316928716908110610cab57fe5b90600052602060002090600302016001015460058660ff16815481101515610ccf57fe5b9060005260206000209060030201600201549250925092509193909250565b600354600160a060020a031681565b6000600160a060020a0383161515610d1457600080fd5b33600090815260208190526040902054821115610d3057600080fd5b33600090815260208190526040902054610d50908363ffffffff61127b16565b3360009081526020819052604080822092909255600160a060020a03851681522054610d82908363ffffffff61128d16565b600160a060020a038416600081815260208181526040918290209390935580518581529051919233927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a350600192915050565b60008083518551141515610df157600080fd5b8351835114610dff57600080fd5b845191506000821115610e7c575060005b818160ff161015610e7c57610e74858260ff16815181101515610e2f57fe5b90602001906020020151858360ff16815181101515610e4a57fe5b90602001906020020151858460ff16815181101515610e6557fe5b90602001906020020151610567565b600101610e10565b5050505050565b600080600084511115610ef6575060005b83518160ff161015610ef6576040805184815290519081900360200190208451859060ff8416908110610ec357fe5b602090810290910181015160408051918252519081900390910190201415610eee5760019150610b82565b600101610e94565b5060009392505050565b6000610f5d6004805480602002602001604051908101604052809291908181526020018280548015610f5257602002820191906000526020600020905b81548152600190910190602001808311610f3d575b505050505084610e83565b1515610f6857600080fd5b610f7182611173565b9050600060ff82161015610f8457600080fd5b6005805460ff8316908110610f9557fe5b600091825260208083206002600390930201919091015485835260069091526040909120541015610fc557600080fd5b6005805460ff8316908110610fd657fe5b600091825260208083206002600390930201919091015494825260069052604090208054939093039092555050565b611060600480548060200260200160405190810160405280929190818152602001828054801561105557602002820191906000526020600020905b81548152600190910190602001808311611040575b505050505082610e83565b1561106a57600080fd5b60048054600181019091557f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b0181905560075460009182526006602052604090912055565b336000908152600260209081526040808320600160a060020a03861684529091528120546110e3908363ffffffff61128d16565b336000818152600260209081526040808320600160a060020a0389168085529083529281902085905580519485525191937f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929081900390910190a350600192915050565b600160a060020a03918216600090815260026020908152604080832093909416825291909152205490565b60008061117f83610a29565b151561118a57600080fd5b60055460001015610a91575060005b60055460ff82161015610a91578260ff1660058260ff168154811015156111bc57fe5b600091825260209091206003909102015460ff1614156111de57809150610a91565b600101611199565b600354600160a060020a031633146111fd57600080fd5b600160a060020a038116151561121257600080fd5b600354604051600160a060020a038084169216907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a36003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b60008282111561128757fe5b50900390565b60008282018381101561129c57fe5b93925050505600a165627a7a72305820f648cf1d6b469361530d2fdd3f4fbdaf9b11b5de7bc3d3aca5a28be862f3b46c0029";

    public static final String FUNC_ADDPRODUCT = "addProduct";

    public static final String FUNC_MINTINGFINISHED = "mintingFinished";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_GETCLIENTBALANCE = "getClientBalance";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_GETPRODUCTSCOUNT = "getProductsCount";

    public static final String FUNC_HASPRODUCTCODE = "hasProductCode";

    public static final String FUNC_DECREASEAPPROVAL = "decreaseApproval";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_COMPARESTRINGS = "compareStrings";

    public static final String FUNC_FINISHMINTING = "finishMinting";

    public static final String FUNC_GETPRODUCTBYINDEX = "getProductByIndex";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_ADDPRODUCTS = "addProducts";

    public static final String FUNC_CONTAINSTRING = "containString";

    public static final String FUNC_BUYPRODUCT = "buyProduct";

    public static final String FUNC_NEWCLIENT = "newClient";

    public static final String FUNC_INCREASEAPPROVAL = "increaseApproval";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_GETPRODUCTINDEX = "getProductIndex";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event MINT_EVENT = new Event("Mint", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event MINTFINISHED_EVENT = new Event("MintFinished", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    protected EventTradeToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EventTradeToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> addProduct(BigInteger _code, byte[] _name, BigInteger _price) {
        final Function function = new Function(
                FUNC_ADDPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_code), 
                new org.web3j.abi.datatypes.generated.Bytes32(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> mintingFinished() {
        final Function function = new Function(FUNC_MINTINGFINISHED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getClientBalance(byte[] _client) {
        final Function function = new Function(FUNC_GETCLIENTBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_client)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> mint(String _to, BigInteger _amount) {
        final Function function = new Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getProductsCount() {
        final Function function = new Function(FUNC_GETPRODUCTSCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> hasProductCode(BigInteger _code) {
        final Function function = new Function(FUNC_HASPRODUCTCODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_code)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> decreaseApproval(String _spender, BigInteger _subtractedValue) {
        final Function function = new Function(
                FUNC_DECREASEAPPROVAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> compareStrings(byte[] a, byte[] b) {
        final Function function = new Function(FUNC_COMPARESTRINGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(a), 
                new org.web3j.abi.datatypes.generated.Bytes32(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> finishMinting() {
        final Function function = new Function(
                FUNC_FINISHMINTING, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<BigInteger, byte[], BigInteger>> getProductByIndex(BigInteger num) {
        final Function function = new Function(FUNC_GETPRODUCTBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(num)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<BigInteger, byte[], BigInteger>>(
                new Callable<Tuple3<BigInteger, byte[], BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, byte[], BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addProducts(List<BigInteger> _code, List<byte[]> _name, List<BigInteger> _price) {
        final Function function = new Function(
                FUNC_ADDPRODUCTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint8>(
                        org.web3j.abi.Utils.typeMap(_code, org.web3j.abi.datatypes.generated.Uint8.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_name, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_price, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> containString(List<byte[]> stringArray, byte[] str) {
        final Function function = new Function(FUNC_CONTAINSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(stringArray, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(str)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> buyProduct(byte[] _client, BigInteger _code) {
        final Function function = new Function(
                FUNC_BUYPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_client), 
                new org.web3j.abi.datatypes.generated.Uint8(_code)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> newClient(byte[] _client) {
        final Function function = new Function(
                FUNC_NEWCLIENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_client)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> increaseApproval(String _spender, BigInteger _addedValue) {
        final Function function = new Function(
                FUNC_INCREASEAPPROVAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_addedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner), 
                new org.web3j.abi.datatypes.Address(_spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getProductIndex(BigInteger _code) {
        final Function function = new Function(FUNC_GETPRODUCTINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_code)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<MintEventResponse> getMintEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINT_EVENT, transactionReceipt);
        ArrayList<MintEventResponse> responses = new ArrayList<MintEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MintEventResponse typedResponse = new MintEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MintEventResponse> mintEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MintEventResponse>() {
            @Override
            public MintEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINT_EVENT, log);
                MintEventResponse typedResponse = new MintEventResponse();
                typedResponse.log = log;
                typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MintEventResponse> mintEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINT_EVENT));
        return mintEventObservable(filter);
    }

    public List<MintFinishedEventResponse> getMintFinishedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINTFINISHED_EVENT, transactionReceipt);
        ArrayList<MintFinishedEventResponse> responses = new ArrayList<MintFinishedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MintFinishedEventResponse typedResponse = new MintFinishedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MintFinishedEventResponse> mintFinishedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MintFinishedEventResponse>() {
            @Override
            public MintFinishedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINTFINISHED_EVENT, log);
                MintFinishedEventResponse typedResponse = new MintFinishedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<MintFinishedEventResponse> mintFinishedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINTFINISHED_EVENT));
        return mintFinishedEventObservable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventObservable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventObservable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public static RemoteCall<EventTradeToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EventTradeToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<EventTradeToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EventTradeToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static EventTradeToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EventTradeToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static EventTradeToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EventTradeToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class MintEventResponse {
        public Log log;

        public String to;

        public BigInteger amount;
    }

    public static class MintFinishedEventResponse {
        public Log log;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class TransferEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger value;
    }
}
