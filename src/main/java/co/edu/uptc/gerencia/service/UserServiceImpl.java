package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.dao.RoleDao;
import co.edu.uptc.gerencia.dao.UserDao;
import co.edu.uptc.gerencia.entity.Role;
import co.edu.uptc.gerencia.entity.User;
import co.edu.uptc.gerencia.user.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public User findByDocumentNumber(String documentNumber) {
        return userDao.findByDocumentNumber(documentNumber);
    }


    @Override
    public void save(WebUser webUser){
        User user = new User();

        user.setUserName(webUser.getUserName());
        user.setPassword(passwordEncoder.encode(webUser.getPassword()));
        user.setFirstName(webUser.getFirstName());
        user.setLastName(webUser.getLastName());
        user.setCellphone(webUser.getCellPhone());
        user.setEmail(webUser.getEmail());
        user.setBirthDate(webUser.getBirthDate());
        user.setGender(webUser.getGender());
        user.setDocumentType(webUser.getDocumentType());
        user.setDocumentNumber(webUser.getDocumentNumber());
        user.setRegistryDate(webUser.getRegistryDate());
        user.setEnabled(true);

        // da al usuario el rol de "usuario" por defecto
        user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));

        // guarda el usuario en la base de datos
        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(user.getRoles());

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                authorities);


    }

    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role tempRole : roles) {
            SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(tempRole.getName());
            authorities.add(tempAuthority);
        }

        return authorities;
    }


}
