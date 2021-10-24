package com.example.blogapi.service;

import com.example.blogapi.convert.UserConvert;
import com.example.blogapi.dto.SearchDTO;
import com.example.blogapi.dto.UserDTO;
import com.example.blogapi.entity.UserEntity;
import com.example.blogapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConvert userConvert;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new User("admin", "password", new ArrayList<>());
    }

    public UserDTO findOneUserById (long idUser) {
        UserEntity userEntity = userRepository.findOneById(idUser);
        if (userEntity != null) {
            return userConvert.toDTO(userEntity);
        }

        return new UserDTO();
    }

    public List<UserDTO> findAll() {
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAll();

        for(UserEntity item : entities) {
            UserDTO userDTO = userConvert.toDTO(item);
            results.add(userDTO);
        }

        return results;
    }

    public List<UserDTO> searchUser (SearchDTO dto) {
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAll();

        for(UserEntity item : entities) {
            if (item.getEmail() != null) {
                if (item.getEmail().contains(dto.getTitle())) {
                    UserDTO userDTO = userConvert.toDTO(item);
                    results.add(userDTO);
                }
            }
        }

        return results;
    }

    public List<UserDTO> searchUserByRanker (SearchDTO dto) {
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAll();

        for(UserEntity item : entities) {
            if (item.getRanker() != null) {
                if (item.getRanker().contains(dto.getTitle())) {
                    UserDTO userDTO = userConvert.toDTO(item);
                    results.add(userDTO);
                }
            }
        }

        return results;
    }

    public UserDTO save(UserDTO dto) {

        UserEntity userEntity = userConvert.toEntity(dto);

        userEntity = userRepository.save(userEntity);

        return userConvert.toDTO(userEntity);
    }

    public UserDTO update (UserDTO dto) {
        UserEntity userEntitySearch = userRepository.findOneById(dto.getId());
        if (userEntitySearch != null) {
            UserEntity userEntity = userConvert.toEntity(dto);
            userEntity.setId(dto.getId());

            userEntity = userRepository.save(userEntity);

            return userConvert.toDTO(userEntity);
        }

        return new UserDTO();
    }

    public void delete (Long id) {
        userRepository.deleteById(id);
    }
}
