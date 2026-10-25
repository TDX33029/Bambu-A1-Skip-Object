package defpackage;

import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class xhb {
    public final String a;
    public final String b;
    public final Map c;
    public final boolean d;
    public final List e;

    public /* synthetic */ xhb(String r3, String r4, Map r5, List r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 16) == 0) goto L8;
        List r72 = null;
    L9:
        this(r3, r4, r5, false, r72);
        return;
    L8:
        r72 = r6;
        goto L9
    }

    public xhb(String r1, String r2, Map r3, boolean r4, List r5) {
        r1.getClass();
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.Map] */
    public static xhb a(xhb r6, huh r7, int r8) {
        String r1 = r6.a;
        String r2 = r6.b;
        huh r72 = r7;
        if ((r8 & 4) == 0) goto L5;
        r72 = r6.c;
    L5:
        huh r3 = r72;
        if ((r8 & 8) == 0) goto L9;
        boolean r73 = r6.d;
    L8:
        boolean r4 = r73;
        List r5 = r6.e;
        r1.getClass();
        return new xhb(r1, r2, r3, r4, r5);
    L9:
        r73 = true;
        goto L8
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof xhb) == true) goto L8;
        return false;
    L8:
        xhb r52 = (xhb) r5;
        if (lsf.l(this.a, r52.a) == true) goto L12;
        return false;
    L12:
        if (lsf.l(this.b, r52.b) == true) goto L15;
        return false;
    L15:
        if (lsf.l(this.c, r52.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r52.d) goto L21;
        return false;
    L21:
        if (lsf.l(this.e, r52.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 0;
        String r3 = this.b;
        if (r3 != null) goto L5;
        int r32 = 0;
    L6:
        int r02 = (r0 + r32) * 31;
        Map r33 = this.c;
        if (r33 != null) goto L9;
        int r34 = 0;
    L10:
        int r03 = b0r.c((r02 + r34) * 31, 31, this.d);
        List r4 = this.e;
        if (r4 == null) goto L15;
        r2 = r4.hashCode();
    L15:
        return r03 + r2;
    L9:
        r34 = r33.hashCode();
        goto L10
    L5:
        r32 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = kn2.v("EncodedCommand(key=", this.a, ", command=", this.b, ", extraData=");
        r0.append(this.c);
        r0.append(", sign=");
        r0.append(this.d);
        r0.append(", encryptKeys=");
        return kn2.q(r0, this.e, ")");
    }
}
