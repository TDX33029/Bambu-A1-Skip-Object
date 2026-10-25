package com.bambulab.bambulab.model;

import defpackage.lsf;
import defpackage.o0g;
import io.sentry.protocol.Device;
import io.sentry.protocol.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000232B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ@\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u001aJ\u0010\u0010#\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u001aR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010*\u0012\u0004\b,\u0010-\u001a\u0004\b+\u0010\u001cR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010*\u0012\u0004\b/\u0010-\u001a\u0004\b.\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b1\u0010\u001f¨\u00064"}, d2 = {"Lcom/bambulab/bambulab/model/IotPlateObjectId;", "", "", "name", "", "objectId", "identifyId", "", "skipped", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$model", "(Lcom/bambulab/bambulab/model/IotPlateObjectId;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Long;", "component3", "component4", "()Ljava/lang/Boolean;", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/bambulab/bambulab/model/IotPlateObjectId;", "toString", "hashCode", "()I", Request.JsonKeys.OTHER, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Ljava/lang/Long;", "getObjectId", "getObjectId$annotations", "()V", "getIdentifyId", "getIdentifyId$annotations", "Ljava/lang/Boolean;", "getSkipped", "Companion", "$serializer", Device.JsonKeys.MODEL}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class IotPlateObjectId {
    public static final Companion Companion = null;
    private final Long identifyId;
    private final String name;
    private final Long objectId;
    private final Boolean skipped;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/bambulab/bambulab/model/IotPlateObjectId$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bambulab/bambulab/model/IotPlateObjectId;", Device.JsonKeys.MODEL}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final KSerializer<IotPlateObjectId> serializer() {
            return IotPlateObjectId$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public IotPlateObjectId() {
        String r1 = null;
        Long r2 = null;
        Long r3 = null;
        Boolean r4 = null;
        this(r1, r2, r3, r4, 15, null);
    }

    public /* synthetic */ IotPlateObjectId(int r2, String r3, Long r4, Long r5, Boolean r6, SerializationConstructorMarker r7) {
        if ((r2 & 1) != 0) goto L5;
        this.name = null;
    L7:
        if ((r2 & 2) != 0) goto L9;
        this.objectId = null;
    L11:
        if ((r2 & 4) != 0) goto L13;
        this.identifyId = null;
    L15:
        if ((r2 & 8) != 0) goto L18;
        this.skipped = null;
        return;
    L18:
        this.skipped = r6;
        return;
    L13:
        this.identifyId = r5;
        goto L15
    L9:
        this.objectId = r4;
        goto L11
    L5:
        this.name = r3;
        goto L7
    }

    public IotPlateObjectId(String r1, Long r2, Long r3, Boolean r4) {
        this.name = r1;
        this.objectId = r2;
        this.identifyId = r3;
        this.skipped = r4;
    }

    public /* synthetic */ IotPlateObjectId(String r2, Long r3, Long r4, Boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public static /* synthetic */ IotPlateObjectId copy$default(IotPlateObjectId r0, String r1, Long r2, Long r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.objectId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.identifyId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.skipped;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    @SerialName("identify_id")
    public static /* synthetic */ void getIdentifyId$annotations() {
    }

    @SerialName("object_id")
    public static /* synthetic */ void getObjectId$annotations() {
    }

    @o0g
    public static final /* synthetic */ void write$Self$model(IotPlateObjectId r3, CompositeEncoder r4, SerialDescriptor r5) {
        if (r4.shouldEncodeElementDefault(r5, 0) == false) goto L6;
    L7:
        r4.encodeNullableSerializableElement(r5, 0, StringSerializer.INSTANCE, r3.name);
    L9:
        if (r4.shouldEncodeElementDefault(r5, 1) == false) goto L12;
    L13:
        r4.encodeNullableSerializableElement(r5, 1, LongSerializer.INSTANCE, r3.objectId);
    L15:
        if (r4.shouldEncodeElementDefault(r5, 2) == false) goto L18;
    L19:
        r4.encodeNullableSerializableElement(r5, 2, LongSerializer.INSTANCE, r3.identifyId);
    L21:
        if (r4.shouldEncodeElementDefault(r5, 3) == false) goto L24;
    L25:
        r4.encodeNullableSerializableElement(r5, 3, BooleanSerializer.INSTANCE, r3.skipped);
        return;
    L24:
        if (r3.skipped != null) goto L25;
        return;
    L18:
        if (r3.identifyId == null) goto L21;
    L12:
        if (r3.objectId == null) goto L15;
    L6:
        if (r3.name == null) goto L9;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final Long component2() {
        return this.objectId;
    }

    public final Long component3() {
        return this.identifyId;
    }

    public final Boolean component4() {
        return this.skipped;
    }

    public final IotPlateObjectId copy(String r1, Long r2, Long r3, Boolean r4) {
        return new IotPlateObjectId(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IotPlateObjectId) == true) goto L8;
        return false;
    L8:
        IotPlateObjectId r52 = (IotPlateObjectId) r5;
        if (lsf.l(this.name, r52.name) == true) goto L12;
        return false;
    L12:
        if (lsf.l(this.objectId, r52.objectId) == true) goto L15;
        return false;
    L15:
        if (lsf.l(this.identifyId, r52.identifyId) == true) goto L18;
        return false;
    L18:
        if (lsf.l(this.skipped, r52.skipped) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final Long getIdentifyId() {
        return this.identifyId;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getObjectId() {
        return this.objectId;
    }

    public final Boolean getSkipped() {
        return this.skipped;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r02 = 0;
    L6:
        int r03 = r02 * 31;
        Long r2 = this.objectId;
        if (r2 != null) goto L9;
        int r22 = 0;
    L10:
        int r04 = (r03 + r22) * 31;
        Long r23 = this.identifyId;
        if (r23 != null) goto L13;
        int r24 = 0;
    L14:
        int r05 = (r04 + r24) * 31;
        Boolean r3 = this.skipped;
        if (r3 == null) goto L19;
        r1 = r3.hashCode();
    L19:
        return r05 + r1;
    L13:
        r24 = r23.hashCode();
        goto L14
    L9:
        r22 = r2.hashCode();
        goto L10
    L5:
        r02 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "IotPlateObjectId(name=" + this.name + ", objectId=" + this.objectId + ", identifyId=" + this.identifyId + ", skipped=" + this.skipped + ")";
    }
}
