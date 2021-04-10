package com.mohit.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mohit.messenger.database.DatabaseClass;
import com.mohit.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("mohit", new Profile(1L, "mohit", "Mohit", "Kumar"));
		profiles.put("mkrs", new Profile(2L, "mkrs", "MKRS", "Kumar"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName); 
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profile.setCreated(new Date());
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}
