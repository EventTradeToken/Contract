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
import org.web3j.abi.datatypes.Utf8String;
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
    private static final String BINARY = "60806040526003805460a060020a60ff0219169055603260075534801561002557600080fd5b5060038054600160a060020a03191633179055611650806100476000396000f3006080604052600436106101055763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166266ac1d811461010a57806305d2035b1461016f578063095ea7b31461019857806318160ddd146101bc57806323b872dd146101e357806334a17d7a1461020d57806340c10f19146102665780634b1b9e921461028a5780635786fd40146102e857806366188463146102fd57806370a08231146103215780637d64bcb41461034257806382e02a07146103575780638da5cb5b146103fa578063a9059cbb1461042b578063d73dd6231461044f578063dd62ed3e14610473578063ef8b9f0a1461049a578063f2fde38b146104f3575b600080fd5b34801561011657600080fd5b5060408051602060046024803582810135601f810185900485028601850190965285855261016d95833560ff1695369560449491939091019190819084018382808284375094975050933594506105149350505050565b005b34801561017b57600080fd5b5061018461062a565b604080519115158252519081900360200190f35b3480156101a457600080fd5b50610184600160a060020a036004351660243561064b565b3480156101c857600080fd5b506101d16106b1565b60408051918252519081900360200190f35b3480156101ef57600080fd5b50610184600160a060020a03600435811690602435166044356106b8565b34801561021957600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261016d94369492936024939284019190819084018382808284375094975061082f9650505050505050565b34801561027257600080fd5b50610184600160a060020a03600435166024356109c2565b34801561029657600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261016d9436949293602493928401919081908401838280828437509497505050923560ff169350610add92505050565b3480156102f457600080fd5b506101d1610d03565b34801561030957600080fd5b50610184600160a060020a0360043516602435610d09565b34801561032d57600080fd5b506101d1600160a060020a0360043516610dfb565b34801561034e57600080fd5b50610184610e1a565b34801561036357600080fd5b5061037260ff60043516610ec0565b6040805160ff85168152908101829052606060208083018281528551928401929092528451608084019186019080838360005b838110156103bd5781810151838201526020016103a5565b50505050905090810190601f1680156103ea5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b34801561040657600080fd5b5061040f610fce565b60408051600160a060020a039092168252519081900360200190f35b34801561043757600080fd5b50610184600160a060020a0360043516602435610fdd565b34801561045b57600080fd5b50610184600160a060020a03600435166024356110be565b34801561047f57600080fd5b506101d1600160a060020a0360043581169060243516611157565b3480156104a657600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101d19436949293602493928401919081908401838280828437509497506111829650505050505050565b3480156104ff57600080fd5b5061016d600160a060020a03600435166112d3565b600554600160008083111561056e575060005b828160ff16101561056e576005805460ff831690811061054357fe5b600091825260209091206003909102015460ff8781169116141561056657600091505b600101610527565b8115610622576040805160608101825260ff88811682526020808301898152938301889052600580546001810180835560009290925284517f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db06003909202918201805460ff191691909516178455945180519195610613937f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db19091019291019061158c565b50604082015181600201555050505b505050505050565b60035474010000000000000000000000000000000000000000900460ff1681565b336000818152600260209081526040808320600160a060020a038716808552908352818420869055815186815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a350600192915050565b6001545b90565b6000600160a060020a03831615156106cf57600080fd5b600160a060020a0384166000908152602081905260409020548211156106f457600080fd5b600160a060020a038416600090815260026020908152604080832033845290915290205482111561072457600080fd5b600160a060020a03841660009081526020819052604090205461074d908363ffffffff61136816565b600160a060020a038086166000908152602081905260408082209390935590851681522054610782908363ffffffff61137a16565b600160a060020a038085166000908152602081815260408083209490945591871681526002825282812033825290915220546107c4908363ffffffff61136816565b600160a060020a03808616600081815260026020908152604080832033845282529182902094909455805186815290519287169391927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929181900390910190a35060019392505050565b6109096004805480602002602001604051908101604052809291908181526020016000905b828210156108ff5760008481526020908190208301805460408051601f60026000196101006001871615020190941693909304928301859004850281018501909152818152928301828280156108eb5780601f106108c0576101008083540402835291602001916108eb565b820191906000526020600020905b8154815290600101906020018083116108ce57829003601f168201915b505050505081526020019060010190610854565b5050505082611390565b1561091357600080fd5b60048054600181018083556000929092528251610957917f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b0190602085019061158c565b50506007546006826040518082805190602001908083835b6020831061098e5780518252601f19909201916020918201910161096f565b51815160209384036101000a6000190180199092169116179052920194855250604051938490030190922092909255505050565b600354600090600160a060020a031633146109dc57600080fd5b60035474010000000000000000000000000000000000000000900460ff1615610a0457600080fd5b600154610a17908363ffffffff61137a16565b600155600160a060020a038316600090815260208190526040902054610a43908363ffffffff61137a16565b600160a060020a03841660008181526020818152604091829020939093558051858152905191927f0f6798a560793a54c3bcfe86a93cde1e73087d944c0ea20544137d412139688592918290030190a2604080518381529051600160a060020a038516916000917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9181900360200190a350600192915050565b6000610bb96004805480602002602001604051908101604052809291908181526020016000905b82821015610baf5760008481526020908190208301805460408051601f6002600019610100600187161502019094169390930492830185900485028101850190915281815292830182828015610b9b5780601f10610b7057610100808354040283529160200191610b9b565b820191906000526020600020905b815481529060010190602001808311610b7e57829003601f168201915b505050505081526020019060010190610b04565b5050505084611390565b1515610bc457600080fd5b610bcd826114a7565b9050600060ff82161015610be057600080fd5b6005805460ff8316908110610bf157fe5b9060005260206000209060030201600201546006846040518082805190602001908083835b60208310610c355780518252601f199092019160209182019101610c16565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092205492909210159150610c73905057600080fd5b6005805460ff8316908110610c8457fe5b9060005260206000209060030201600201546006846040518082805190602001908083835b60208310610cc85780518252601f199092019160209182019101610ca9565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092208054939093039092555050505050565b60055490565b336000908152600260209081526040808320600160a060020a038616845290915281205480831115610d5e57336000908152600260209081526040808320600160a060020a0388168452909152812055610d93565b610d6e818463ffffffff61136816565b336000908152600260209081526040808320600160a060020a03891684529091529020555b336000818152600260209081526040808320600160a060020a0389168085529083529281902054815190815290519293927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929181900390910190a3600191505b5092915050565b600160a060020a0381166000908152602081905260409020545b919050565b600354600090600160a060020a03163314610e3457600080fd5b60035474010000000000000000000000000000000000000000900460ff1615610e5c57600080fd5b6003805474ff00000000000000000000000000000000000000001916740100000000000000000000000000000000000000001790556040517fae5184fba832cb2b1f702aca6117b8d265eaf03ad33eb133f19dde0f5920fa0890600090a150600190565b60006060600060058460ff16815481101515610ed857fe5b60009182526020909120600390910201546005805460ff928316928716908110610efe57fe5b906000526020600020906003020160010160058660ff16815481101515610f2157fe5b60009182526020918290206002600390920201810154835460408051601f600019610100600186161502019093169490940491820185900485028401850190528083529092849190830182828015610fba5780601f10610f8f57610100808354040283529160200191610fba565b820191906000526020600020905b815481529060010190602001808311610f9d57829003601f168201915b505050505091509250925092509193909250565b600354600160a060020a031681565b6000600160a060020a0383161515610ff457600080fd5b3360009081526020819052604090205482111561101057600080fd5b33600090815260208190526040902054611030908363ffffffff61136816565b3360009081526020819052604080822092909255600160a060020a03851681522054611062908363ffffffff61137a16565b600160a060020a038416600081815260208181526040918290209390935580518581529051919233927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a350600192915050565b336000908152600260209081526040808320600160a060020a03861684529091528120546110f2908363ffffffff61137a16565b336000818152600260209081526040808320600160a060020a0389168085529083529281902085905580519485525191937f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929081900390910190a350600192915050565b600160a060020a03918216600090815260026020908152604080832093909416825291909152205490565b600061125e6004805480602002602001604051908101604052809291908181526020016000905b828210156112545760008481526020908190208301805460408051601f60026000196101006001871615020190941693909304928301859004850281018501909152818152928301828280156112405780601f1061121557610100808354040283529160200191611240565b820191906000526020600020905b81548152906001019060200180831161122357829003601f168201915b5050505050815260200190600101906111a9565b5050505083611390565b156112cb576006826040518082805190602001908083835b602083106112955780518252601f199092019160209182019101611276565b51815160209384036101000a60001901801990921691161790529201948552506040519384900301909220549250610e15915050565b506000610e15565b600354600160a060020a031633146112ea57600080fd5b600160a060020a03811615156112ff57600080fd5b600354604051600160a060020a038084169216907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a36003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b60008282111561137457fe5b50900390565b60008282018381101561138957fe5b9392505050565b60008060008451111561149d575060005b83518160ff16101561149d57826040518082805190602001908083835b602083106113dd5780518252601f1990920191602091820191016113be565b5181516020939093036101000a60001901801990911692169190911790526040519201829003909120875190935087925060ff85169150811061141c57fe5b906020019060200201516040518082805190602001908083835b602083106114555780518252601f199092019160209182019101611436565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390206000191614156114955760019150610df4565b6001016113a1565b5060009392505050565b6000806114b383611520565b15156114be57600080fd5b6005546000101561151a575060005b60055460ff8216101561151a578260ff1660058260ff168154811015156114f057fe5b600091825260209091206003909102015460ff1614156115125780915061151a565b6001016114cd565b50919050565b60008060006005805490501115611583575060005b60055460ff82161015611583578260ff1660058260ff1681548110151561155857fe5b600091825260209091206003909102015460ff16141561157b576001915061151a565b600101611535565b50600092915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106115cd57805160ff19168380011785556115fa565b828001600101855582156115fa579182015b828111156115fa5782518255916020019190600101906115df565b5061160692915061160a565b5090565b6106b591905b8082111561160657600081556001016116105600a165627a7a72305820d49167ab9122c78a12e16cc5cc8aa8d8dcfa72d05dde26ff926379c096ed1d510029";

    public static final String FUNC_ADDPRODUCT = "addProduct";

    public static final String FUNC_MINTINGFINISHED = "mintingFinished";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_NEWCLIENT = "newClient";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_BUYPRODUCT = "buyProduct";

    public static final String FUNC_GETPRODUCTSCOUNT = "getProductsCount";

    public static final String FUNC_DECREASEAPPROVAL = "decreaseApproval";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_FINISHMINTING = "finishMinting";

    public static final String FUNC_GETPRODUCTBYINDEX = "getProductByIndex";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_INCREASEAPPROVAL = "increaseApproval";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_GETCLIENTBALANCE = "getClientBalance";

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

    public RemoteCall<TransactionReceipt> addProduct(BigInteger _code, String _name, BigInteger _price) {
        final Function function = new Function(
                FUNC_ADDPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_code), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
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

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> newClient(String _client) {
        final Function function = new Function(
                FUNC_NEWCLIENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_client)), 
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

    public RemoteCall<TransactionReceipt> buyProduct(String _client, BigInteger _code) {
        final Function function = new Function(
                FUNC_BUYPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_client), 
                new org.web3j.abi.datatypes.generated.Uint8(_code)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getProductsCount() {
        final Function function = new Function(FUNC_GETPRODUCTSCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<TransactionReceipt> finishMinting() {
        final Function function = new Function(
                FUNC_FINISHMINTING, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<BigInteger, String, BigInteger>> getProductByIndex(BigInteger num) {
        final Function function = new Function(FUNC_GETPRODUCTBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(num)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<BigInteger, String, BigInteger>>(
                new Callable<Tuple3<BigInteger, String, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
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

    public RemoteCall<BigInteger> getClientBalance(String _client) {
        final Function function = new Function(FUNC_GETCLIENTBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_client)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<EventTradeToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EventTradeToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<EventTradeToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EventTradeToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
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
