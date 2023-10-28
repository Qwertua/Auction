import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateLotPriceComponent } from './update-lot-price.component';

describe('UpdateLotPriceComponent', () => {
  let component: UpdateLotPriceComponent;
  let fixture: ComponentFixture<UpdateLotPriceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateLotPriceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateLotPriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
