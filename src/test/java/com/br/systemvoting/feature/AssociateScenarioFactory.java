package com.br.systemvoting.feature;

import com.br.systemvoting.domain.Associate;
import com.br.systemvoting.domain.dto.associate.request.AssociateRequest;
import com.br.systemvoting.domain.dto.associate.response.AssociateResponse;

public class AssociateScenarioFactory {
    
    public static final Associate ASSOCIATE = loadAssociate();
    public static final Associate ASSOCIATE_NEW = loadNewAssociate();
    public static final Associate ASSOCIATE_BUILDER = loadAssociateBuilder();
    public static final Associate ASSOCIATE_SET = loadAssociateSet();
    public static final Associate ASSOCIATE_GET = loadAssociateGet();
    public static final AssociateRequest ASSOCIATE_REQUEST = loadAssociateRequest();
    public static final AssociateResponse ASSOCIATE_RESPONSE=loadAssociadoResponse();

    private static Associate loadAssociate() {
        return new Associate(1L, "58218785000", null);
    }

    private static Associate loadNewAssociate() {
        return new Associate(1L, "12345678911", null);
    }

    private static Associate loadAssociateBuilder() {
        return Associate.builder()
        .associateId(2L)
        .cpf("21365487905")
        .vote(null)
        .build();
    }

    private static Associate loadAssociateSet() {
        Associate associate = new Associate();
        associate.setAssociateId(3L);
        associate.setCpf("74125896325");
        associate.setVote(null);
        return associate;
    }

    private static Associate loadAssociateGet() {
        Associate associate = new Associate();
        associate.getAssociateId();
        associate.getCpf();
        associate.getVote();
        return associate;
    }

    private static AssociateRequest loadAssociateRequest() {
        return new AssociateRequest("58218785000");
    }

    private static AssociateResponse loadAssociadoResponse() {
        return AssociateResponse.builder().cpf("58218785000").associateId(1L).build();
    }
}
