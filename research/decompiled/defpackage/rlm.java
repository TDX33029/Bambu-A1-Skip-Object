package defpackage;

/* loaded from: classes3.dex */
public final class rlm {
    public final vem a;
    public final sjm b;
    public final pam c;
    public final ukm d;

    public rlm(vem r1, sjm r2, pam r3, ukm r4) {
        r1.getClass();
        r2.getClass();
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L5;
        return true;
    L5:
        if ((r4 instanceof rlm) == false) goto L18;
        rlm r42 = (rlm) r4;
        if (lsf.l(this.a, r42.a) == false) goto L18;
        if (lsf.l(this.b, r42.b) == false) goto L18;
        if (this.c == r42.c) goto L17;
        return false;
    L17:
        if (this.d.equals(r42.d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r1 = (this.b.hashCode() + r0) * 31;
        int r02 = (this.c.hashCode() + r1) * 31;
        return this.d.hashCode() + r02;
    }

    public final String toString() {
        return "PrintSummaryTaskCardDeps(ratingRepository=" + this.a + ", navigator=" + this.b + ", printControl=" + this.c + ", toastMessages=" + this.d + ")";
    }
}
