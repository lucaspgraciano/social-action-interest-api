package com.br.social.action.interest.services.fetch;

import com.br.social.action.interest.SocialAction;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

public class FetchSocialActionResponse {
    @JsonSerialize
    private List<SocialAction> socialActions;

    public FetchSocialActionResponse(List<SocialAction> socialActions) { this.socialActions = socialActions; }

}
