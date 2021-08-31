package capgemini.emp_asset.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import capgemini.emp_asset.entity.Asset;
import capgemini.emp_asset.entity.AssetRequest;
import capgemini.emp_asset.entity.Employee;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssetRequestServiceImplTest {

	@Autowired
	private AssetRequestServiceImpl assetReqService;
	
	@Test
	public final void testGetAllAssetRequest() {
		List<AssetRequest> assets = assetReqService.getAllAssetRequest();
		assertThat(assets.size()>0);
	}

	@Test
	public final void testGetAssetRequest() {
		Optional<AssetRequest> asset = assetReqService.getAssetRequest(1);
		assertThat(asset.get().getAssetReqId()==1);
	}

	@Ignore
	public final void testAddAssetRequest() {
		AssetRequest req = new AssetRequest();
		Asset asset = new Asset();
		Employee emp = new Employee();
		
		req.setAssetReqId(4);
		req.setDate(LocalDate.of(2021, 9, 05));
		asset.setAssetId(4);
		asset.setDescription("Keyboard");
		asset.setType("HW");
		
		emp.setName("pqr");
		emp.setRole("Analyst");
		
		req=assetReqService.addAssetRequest(req);
		assertThat(asset.getDescription().equalsIgnoreCase("Keyboard"));
	}

	@Test
	public final void testRemoveAssetRequest() {
		AssetRequest req = new AssetRequest();
		Asset asset = new Asset();
		Employee emp = new Employee();
		
		req.setAssetReqId(5);
		//req.setDate("2021-09-05");
		asset.setAssetId(4);
		asset.setDescription("Keyboard");
		asset.setType("HW");
		
		emp.setName("pqr");
		emp.setRole("Analyst");
		
		req=assetReqService.addAssetRequest(req);
		assetReqService.removeAssetRequest(req);
		assertThat(req.getAssetReqId()==0);
	}

	@Test
	public final void testEditAssetRequest() {
		AssetRequest req = new AssetRequest();
		Asset asset = new Asset();
		Employee emp = new Employee();
		
		req.setAssetReqId(4);
		req.setDate(LocalDate.of(2021, 9, 05));
		asset.setAssetId(4);
		asset.setDescription("PC");
		asset.setType("HW");
		
		emp.setName("pqr");
		emp.setRole("Analyst");
		
		req=assetReqService.editAssetRequest(req);
		assertThat(asset.getDescription().equalsIgnoreCase("PC"));
	}

}
