package defpackage;

import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* loaded from: classes2.dex */
public final class a03 {
    public final c53 a;
    public final ArrayList b;
    public final Set c;
    public final b1q d;
    public final String e;
    public final Function1 f;

    public a03(c53 r1, ArrayList r2, Set r3, b1q r4, String r5, Function1 r6) {
        r6.getClass();
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if ((r3 instanceof a03) == false) goto L28;
        a03 r32 = (a03) r3;
        if (this.a == r32.a) goto L11;
        return false;
    L11:
        if (this.b.equals(r32.b) == true) goto L14;
        return false;
    L14:
        if (this.c.equals(r32.c) == true) goto L17;
        return false;
    L17:
        if (this.d.equals(r32.d) == true) goto L20;
        return false;
    L20:
        if (lsf.l(this.e, r32.e) == true) goto L23;
        return false;
    L23:
        if (lsf.l(this.f, r32.f) == true) goto L26;
        return false;
    L26:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r02 = bsa.g(this.b, r0, 31);
        int r03 = b0r.d(this.c, r02, 31);
        int r2 = (this.d.hashCode() + r03) * 31;
        String r04 = this.e;
        if (r04 != null) goto L5;
        int r05 = 0;
    L6:
        int r3 = this.f.hashCode();
        return r3 + ((r2 + r05) * 31);
    L5:
        r05 = r04.hashCode();
        goto L6
    }

    public final String toString() {
        return "BblRawSkipObjectsPickerParams(mode=" + this.a + ", objects=" + this.b + ", initialSelectedIds=" + this.c + ", imageSource=" + this.d + ", deviceModelName=" + this.e + ", onConfirm=" + this.f + ")";
    }
}
