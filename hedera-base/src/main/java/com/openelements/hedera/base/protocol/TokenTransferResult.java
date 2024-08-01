package com.openelements.hedera.base.protocol;

import com.hedera.hashgraph.sdk.Status;
import com.hedera.hashgraph.sdk.TransactionId;

public record TokenTransferResult(TransactionId transactionId, Status status) implements TransactionResult{

}
