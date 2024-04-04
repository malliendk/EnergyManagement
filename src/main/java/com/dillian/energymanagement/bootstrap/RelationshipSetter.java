package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Locality;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.services.locality.LocalityServiceImpl;
import com.dillian.energymanagement.services.supervisor.SupervisorServiceImpl;
import com.dillian.energymanagement.utils.Constants;
import com.dillian.energymanagement.utils.Localities;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RelationshipSetter {


    private final AccountGenerator accountGenerator;
    private final DistributorGenerator distributorGenerator;
    private final SupervisorGenerator supervisorGenerator;
    private final LocalityGenerator localityGenerator;
    private final SupervisorServiceImpl supervisorService;
    private final LocalityServiceImpl localityService;
    private final SampleRecordSaver saver;

    public RelationshipSetter(final AccountGenerator accountGenerator, final DistributorGenerator distributorGenerator, final SupervisorGenerator supervisorGenerator, final LocalityGenerator localityGenerator, final SupervisorServiceImpl supervisorService, final LocalityServiceImpl localityService, final SampleRecordSaver saver) {
        this.accountGenerator = accountGenerator;
        this.distributorGenerator = distributorGenerator;
        this.supervisorGenerator = supervisorGenerator;
        this.localityGenerator = localityGenerator;
        this.supervisorService = supervisorService;
        this.localityService = localityService;
        this.saver = saver;
    }

    private List<Account> accounts;
    private List<Locality> localities;
    private List<Distributor> distributors;
    private List<Supervisor> supervisors;
    private Distributor liander;
    private Distributor stedin;
    private Supervisor ameliaLupina;
    private Supervisor tessaSavours;
    private Supervisor marcusCaldwell;
    private Supervisor KaitoTanaka;
    private Locality apeldoorn;
    private Locality zutphen;
    private Locality putten;

    private static final Random random = new Random();


    public void initializeObjectsAndSetRelationships() {
        this.accounts = accountGenerator.createWithBasicProperties(50);
        this.localities = localityGenerator.createWithBasicProperties();
        this.distributors = distributorGenerator.createWithBasicProperties();
        this.supervisors = supervisorGenerator.createWithBasicProperties();

        this.liander = distributors.get(0);
        this.stedin = distributors.get(1);
        this.ameliaLupina = supervisorService.findByLastName("Lupina");
        this.tessaSavours = supervisorService.findByLastName("Savours");
        this.marcusCaldwell = supervisorService.findByLastName("Caldwell");
        this.KaitoTanaka = supervisorService.findByLastName("Tanaka");
        this.apeldoorn = localityService.findByName("Amersfoort");
        this.zutphen = localityService.findByName("Zutphen");
        this.putten = localityService.findByName("Leiden");

        this.accounts = setForAccounts(Constants.numberOfAccounts);
        this.localities = setForLocalities();
        this.distributors = setForDistributors();
        this.supervisors = setForSupervisors();

        saveEntities();
    }


    public List<Account> setForAccounts(int numberOfAccounts) {
        for (Account account : this.accounts) {
            final Locality localityToSet = pickRandomLocality();
            account.setLocality(localityToSet);
            account.setDistributor(liander);
        }
        return accounts;
    }

    public List<Distributor> setForDistributors() {
        distributors.forEach(distributor ->
                distributor.setAccounts(accounts
                        .stream()
                        .filter(account -> account.getDistributor().getName().equals(distributor.getName()))
                        .toList()));
        liander.setSupervisors(List.of(ameliaLupina, tessaSavours));
        stedin.setSupervisors(List.of(marcusCaldwell, KaitoTanaka));
        return distributors;
    }

    public List<Supervisor> setForSupervisors() {
        ameliaLupina.setDistributor(this.liander);
        ameliaLupina.setLocalities(List.of(apeldoorn, zutphen, putten));
        tessaSavours.setDistributor(this.liander);
        KaitoTanaka.setDistributor(this.stedin);
        marcusCaldwell.setDistributor(this.stedin);
        return List.of(ameliaLupina, tessaSavours, KaitoTanaka, marcusCaldwell);
    }

    public List<Locality> setForLocalities() {
        localities.forEach(locality ->
                locality.setAccounts(accounts
                        .stream()
                        .filter(account -> account.getLocality().getName().equals(locality.getName()))
                        .toList()));
        apeldoorn.setSupervisors(List.of(ameliaLupina));
        zutphen.setSupervisors(List.of(ameliaLupina));
        putten.setSupervisors(List.of(ameliaLupina));
        return localities;

    }

    private Locality pickRandomLocality() {
        Locality[] selectedLocalities = new Locality[]{apeldoorn, zutphen, putten};
        int randomElement = random.nextInt(Localities.localities.length);
        return selectedLocalities[randomElement];
    }

    private void saveEntities() {
        saver.saveAccounts(accounts);
        saver.saveLocalities(localities);
        saver.saveLocalities(List.of(apeldoorn, zutphen, putten));
        saver.saveDistributors(distributors);
        saver.saveDistributors(List.of(liander, stedin));
        saver.saveSupervisors(supervisors);
        saver.saveSupervisors(List.of(ameliaLupina, tessaSavours));
    }
}
