package defpackage;

/* loaded from: classes2.dex */
public final class djm {
    public final String a;
    public final int b;
    public final int c;
    public final boolean d;

    public djm(String r1, int r2, int r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public static djm a(djm r1, String r2, boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        return new djm(r2, r1.b, r1.c, r3);
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof djm) == true) goto L8;
        return false;
    L8:
        djm r52 = (djm) r5;
        if (lsf.l(this.a, r52.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r52.b) goto L15;
        return false;
    L15:
        if (this.c == r52.c) goto L18;
        return false;
    L18:
        if (this.d == r52.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r02 = 0;
    L6:
        int r2 = this.b;
        int r03 = r77.a(r2, r02 * 31, 31);
        int r04 = r77.a(this.c, r03, 31);
        return Boolean.hashCode(this.d) + r04;
    L5:
        r02 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = kn2.s(this.b, "PrintSkipObject(name=", this.a, ", identifyId=", ", colorArgb=");
        r0.append(this.c);
        r0.append(", skipped=");
        r0.append(this.d);
        r0.append(")");
        return r0.toString();
    }
}
