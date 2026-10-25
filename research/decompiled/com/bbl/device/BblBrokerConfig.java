package com.bbl.device;

import com.alipay.sdk.m.n.c;
import com.bbl.mqtt.api.model.BrokerConfig;
import com.bbl.mqtt.api.model.MqttTransport;
import com.bbl.mqtt.api.model.MqttVersion;
import com.bbl.mqtt.api.model.WillConfig;
import com.igexin.push.core.b;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.muq;
import defpackage.n57;
import defpackage.ul7;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bbl/device/BblBrokerConfig;", "", "<init>", "()V", "Lcom/bbl/mqtt/api/model/BrokerConfig;", b.X, "Ln57;", "inferConnectionMode$device_biz", "(Lcom/bbl/mqtt/api/model/BrokerConfig;)Ln57;", "inferConnectionMode", "", "deviceIp", "accessCode", "", "ssl", "", "port", "local", "(Ljava/lang/String;Ljava/lang/String;ZI)Lcom/bbl/mqtt/api/model/BrokerConfig;", "userId", "accessToken", "clientId", c.f, "remote", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)Lcom/bbl/mqtt/api/model/BrokerConfig;", "platform", "hardwareId", "remoteClientId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "PORT", "I", "PORT_SSL", "REMOTE_HOST", "Ljava/lang/String;", "device-biz"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BblBrokerConfig {
    public static final BblBrokerConfig INSTANCE = null;
    public static final int PORT = 1883;
    public static final int PORT_SSL = 8883;
    public static final String REMOTE_HOST = "us.mqtt.bambulab.com";

    static {
        INSTANCE = new BblBrokerConfig();
    }

    private BblBrokerConfig() {
    }

    public static /* synthetic */ BrokerConfig local$default(BblBrokerConfig r0, String r1, String r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = true;
    L6:
        if ((r5 & 8) == 0) goto L11;
        if (r3 == false) goto L9;
        r4 = 8883;
        goto L11
    L9:
        r4 = 1883;
    L11:
        return r0.local(r1, r2, r3, r4);
    }

    public static /* synthetic */ BrokerConfig remote$default(BblBrokerConfig r7, String r8, String r9, String r10, String r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = REMOTE_HOST;
    L5:
        String r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r12 = true;
    L8:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L15;
        if (r5 == false) goto L13;
        int r112 = 8883;
    L12:
        r13 = r112;
        goto L15
    L13:
        r112 = 1883;
    L15:
        return r7.remote(r8, r9, r10, r4, r5, r13);
    }

    public final n57 inferConnectionMode$device_biz(BrokerConfig r2) {
        r2.getClass();
        String r1 = r2.getUsername();
        if (r1 == null) goto L9;
        if (muq.f0(r1, "u_", false) != true) goto L9;
        return n57.b;
    L9:
        return n57.a;
    }

    public final BrokerConfig local(String r20, String r21, boolean r22, int r23) {
        r20.getClass();
        r21.getClass();
        String r3 = UUID.randomUUID().toString();
        r3.getClass();
        String r4 = "bblp";
        int r7 = 0;
        boolean r8 = true;
        int r9 = 0;
        Integer r10 = null;
        MqttTransport r11 = null;
        String r12 = null;
        List r13 = null;
        Map r15 = null;
        WillConfig r16 = null;
        return new BrokerConfig(r20, r23, r3, r4, r21, r22, r7, r8, r9, r10, r11, r12, r13, MqttVersion.V3_1_1, r15, r16, 57152, null);
    }

    public final BrokerConfig remote(String r20, String r21, String r22, String r23, boolean r24, int r25) {
        r20.getClass();
        r21.getClass();
        r22.getClass();
        r23.getClass();
        int r7 = 0;
        boolean r8 = true;
        int r9 = 0;
        Integer r10 = null;
        MqttTransport r11 = null;
        String r12 = null;
        List r13 = null;
        Map r15 = null;
        WillConfig r16 = null;
        return new BrokerConfig(r23, r25, r22, "u_".concat(r20), r21, r24, r7, r8, r9, r10, r11, r12, r13, MqttVersion.V3_1_1, r15, r16, 57152, null);
    }

    public final String remoteClientId(String r1, String r2, String r3) {
        r1.getClass();
        r2.getClass();
        r3.getClass();
        StringBuilder r0 = new StringBuilder(r1);
        r0.append(Constants.COLON_SEPARATOR);
        return ul7.m(r0, r2, Constants.COLON_SEPARATOR, r3);
    }
}
