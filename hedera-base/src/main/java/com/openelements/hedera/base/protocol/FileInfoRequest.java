package com.openelements.hedera.base.protocol;

import com.hedera.hashgraph.sdk.FileId;
import com.hedera.hashgraph.sdk.Hbar;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import java.util.Objects;

public record FileInfoRequest(@NonNull FileId fileId, @Nullable Hbar queryPayment, @Nullable Hbar maxQueryPayment) implements QueryRequest {

    public FileInfoRequest {
        Objects.requireNonNull(fileId, "fileId must not be null");
    }

    @NonNull
    public static FileInfoRequest of(@NonNull String fileId) {
        Objects.requireNonNull(fileId, "fileId must not be null");
        return of(FileId.fromString(fileId));
    }

    @NonNull
    public static FileInfoRequest of(@NonNull FileId fileId) {
        return new FileInfoRequest(fileId, null, null);
    }

    @Override
    public Hbar queryPayment() {
        return queryPayment;
    }

    @Override
    public Hbar maxQueryPayment() {
        return maxQueryPayment;
    }
}
