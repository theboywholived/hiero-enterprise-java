package com.openelements.hedera.base.implementation;

import com.hedera.hashgraph.sdk.AccountId;
import com.hedera.hashgraph.sdk.TokenId;
import com.openelements.hedera.base.HederaException;
import com.openelements.hedera.base.Nft;
import com.openelements.hedera.base.NftRepository;
import com.openelements.hedera.base.mirrornode.MirrorNodeClient;
import org.jspecify.annotations.NonNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NftRepositoryImpl implements NftRepository {

    private final MirrorNodeClient mirrorNodeClient;

    public NftRepositoryImpl(@NonNull final MirrorNodeClient mirrorNodeClient) {
        this.mirrorNodeClient = Objects.requireNonNull(mirrorNodeClient, "mirrorNodeClient must not be null");
    }

    @NonNull
    @Override
    public List<Nft> findByOwner(@NonNull final AccountId owner) throws HederaException {
        return mirrorNodeClient.queryNftsByAccount(owner);
    }

    @NonNull
    @Override
    public List<Nft> findByType(@NonNull final TokenId tokenId) throws HederaException {
        return mirrorNodeClient.queryNftsByTokenId(tokenId);
    }

    @NonNull
    @Override
    public Optional<Nft> findByTypeAndSerial(@NonNull final TokenId tokenId, final long serialNumber) throws HederaException {
        return mirrorNodeClient.queryNftsByTokenIdAndSerial(tokenId, serialNumber);
    }

    @NonNull
    @Override
    public List<Nft> findByOwnerAndType(@NonNull final AccountId owner, @NonNull final TokenId tokenId) throws HederaException {
        return mirrorNodeClient.queryNftsByAccountAndTokenId(owner, tokenId);
    }

    @NonNull
    @Override
    public Optional<Nft> findByOwnerAndTypeAndSerial(@NonNull final AccountId owner, @NonNull final TokenId tokenId,
            final long serialNumber) throws HederaException {
        return mirrorNodeClient.queryNftsByAccountAndTokenIdAndSerial(owner, tokenId, serialNumber);
    }
}
