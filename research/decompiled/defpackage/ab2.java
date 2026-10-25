package defpackage;

import java.util.List;

/* loaded from: classes4.dex */
public final class ab2 extends ob2 {
    public final List a;

    public ab2(List r1) {
        r1.getClass();
        this.a = r1;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ab2) == true) goto L9;
        return false;
    L9:
        if (lsf.l(this.a, ((ab2) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return i3e.h("SkipObjects(objectList=", ")", this.a);
    }
}
