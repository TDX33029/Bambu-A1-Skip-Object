package com.bbl.device.command;

import defpackage.jfn;
import defpackage.ob2;
import defpackage.rf7;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\bJD\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/bbl/device/command/BblCommandGateway;", "", "Lob2;", "request", "", "timeoutMs", "Lcom/bbl/device/command/BblCommandReceipt;", "send", "(Lob2;JLrf7;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "", "parser", "Lcom/bbl/device/command/BblTypedReceipt;", "(Lob2;Lkotlin/jvm/functions/Function1;JLrf7;)Ljava/lang/Object;", "device-biz"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BblCommandGateway {

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object send$default(BblCommandGateway r0, ob2 r1, long r2, rf7 r4, int r5, Object r6) {
            return BblCommandGateway.send$default(r0, r1, r2, r4, r5, r6);
        }

        public static /* synthetic */ Object send$default(BblCommandGateway r0, ob2 r1, Function1 r2, long r3, rf7 r5, int r6, Object r7) {
            return BblCommandGateway.send$default(r0, r1, r2, r3, r5, r6, r7);
        }
    }

    static /* synthetic */ Object send$default(BblCommandGateway r0, ob2 r1, long r2, rf7 r4, int r5, Object r6) {
        if (r6 == null) goto L4;
        jfn.w("Super calls with default arguments not supported in this target, function: send");
        return null;
    L4:
        if ((r5 & 2) == 0) goto L7;
        r2 = AbstractTrafficShapingHandler.DEFAULT_MAX_TIME;
    L7:
        return r0.send(r1, r2, r4);
    }

    static /* synthetic */ Object send$default(BblCommandGateway r6, ob2 r7, Function1 r8, long r9, rf7 r11, int r12, Object r13) {
        if (r13 == null) goto L4;
        jfn.w("Super calls with default arguments not supported in this target, function: send");
        return null;
    L4:
        if ((r12 & 4) == 0) goto L7;
        r9 = AbstractTrafficShapingHandler.DEFAULT_MAX_TIME;
    L7:
        return r6.send(r7, r8, r9, r11);
    }

    Object send(ob2 r1, long r2, rf7<? super BblCommandReceipt> r4);

    <T> Object send(ob2 r1, Function1<? super byte[], ? extends T> r2, long r3, rf7<? super BblTypedReceipt<? extends T>> r5);
}
