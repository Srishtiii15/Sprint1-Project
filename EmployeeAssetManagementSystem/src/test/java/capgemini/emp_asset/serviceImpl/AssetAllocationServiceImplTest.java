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

import capgemini.emp_asset.entity.AssetAllocation;
import capgemini.emp_asset.entity.AssetRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AssetAllocationServiceImplTest {

	@Autowired
	private AssetAllocationServiceImpl assetAllocationService;
	
	@Test
	public final void testGetAllAssetAllocation() {
		List<AssetAllocation> assets = assetAllocationService.getAllAssetAllocation();
		assertThat(assets.size()>0);
	}

	@Ignore
	public final void testGetAssetAllocation() {
		Optional<AssetAllocation> asset = assetAllocationService.getAssetAllocation(1);
		assertThat(asset.get().getassetAllocationId()==1);
	}

	@Test
	public final void testAddAssetAllocation() {
		AssetAllocation assetal = new AssetAllocation();
		AssetRequest assetReq = new AssetRequest();
		
		assetal.setAssetAllocationId(4);
		assetal.setDate(LocalDate.of(2021, 9, 10));
		
		assetReq.setAssetReqId(4);
		assetReq.setDate(LocalDate.of(2021, 9, 05));
		
		assetal = assetAllocationService.addAssetAllocation(assetal);
		assertThat(assetal.getDate().equals(LocalDate.of(2021, 9, 10)));
	}

	@Test
	public final void testRemoveAssetAllocation() {
		AssetAllocation assetal = new AssetAllocation();
		AssetRequest assetReq = new AssetRequest();
		
		assetal.setAssetAllocationId(5);
		assetal.setDate(LocalDate.of(2021, 9, 11));
		
		assetReq.setAssetReqId(5);
		assetReq.setDate(LocalDate.of(2021, 9, 06));
		
		assetal = assetAllocationService.addAssetAllocation(assetal);
		assetAllocationService.removeAssetAllocation(assetal);
		assertThat(assetal.getassetAllocationId()==0);
	}

	@Test
	public final void testEditAssetAllocation() {
		AssetAllocation assetal = new AssetAllocation();
		
		assetal.setAssetAllocationId(1);
		assetal.setDate(LocalDate.of(2021, 9, 01));

		assetal = assetAllocationService.editAssetAllocation(assetal);
		assertThat(assetal.getDate().datesUntil(LocalDate.of(2021, 9, 01)));
	}

}
